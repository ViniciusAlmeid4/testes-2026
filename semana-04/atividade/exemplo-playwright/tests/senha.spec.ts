import { test, expect } from "@playwright/test";

const casos = [
  {
    senha: "Passwor",
    confirmacao: "Passwor",
    sucesso: false,
    texto: "Senha fora do padrão",
    desc: "abaixo do mínimo (7 caracteres)",
  },
  {
    senha: "Passwor1",
    confirmacao: "Passwor1",
    sucesso: true,
    texto: "Senha cadastrada",
    desc: "limite mínimo (8 caracteres)",
  },
  {
    senha: "Password123456789012",
    confirmacao: "Password123456789012",
    sucesso: true,
    texto: "Senha cadastrada",
    desc: "limite máximo (20 caracteres)",
  },
  {
    senha: "Password1234567890123",
    confirmacao: "Password1234567890123",
    sucesso: false,
    texto: "Senha fora do padrão",
    desc: "acima do máximo (21 caracteres)",
  },
  {
    senha: "password1",
    confirmacao: "password1",
    sucesso: false,
    texto: "Senha fora do padrão",
    desc: "sem letra maiúscula",
  },
  {
    senha: "PASSWORD1",
    confirmacao: "PASSWORD1",
    sucesso: false,
    texto: "Senha fora do padrão",
    desc: "sem letra minúscula",
  },
  {
    senha: "Password!",
    confirmacao: "Password!",
    sucesso: false,
    texto: "Senha fora do padrão",
    desc: "sem número",
  },
  {
    senha: "Pass word1",
    confirmacao: "Pass word1",
    sucesso: false,
    texto: "Senha fora do padrão",
    desc: "contendo espaço",
  },
  {
    senha: "",
    confirmacao: "",
    sucesso: false,
    texto: "Senha fora do padrão",
    desc: "campos vazios",
  },
  {
    senha: "Password123",
    confirmacao: "Diferente123",
    sucesso: false,
    texto: "As senhas não coincidem",
    desc: "confirmação diferente da senha",
  },
];

test.describe("validação de senha", () => {
  for (const caso of casos) {
    test(`deve lidar com ${caso.desc}`, async ({ page }) => {
      await page.goto("/senha");

      await page.getByLabel("Nova senha").fill(caso.senha);
      await page.getByLabel("Confirmar senha").fill(caso.confirmacao);
      await page.getByRole("button", { name: "Cadastrar senha" }).click();

      const resultado = page.locator("#resultado");
      await expect(resultado).toBeVisible();
      await expect(resultado).toHaveText(caso.texto);

      if (caso.sucesso) {
        await expect(resultado).toHaveAttribute("role", "status");
        await expect(resultado).toHaveClass("success");
      } else {
        await expect(resultado).toHaveAttribute("role", "alert");
        await expect(resultado).toHaveClass("");
      }
    });
  }
});
