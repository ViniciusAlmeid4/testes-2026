import { test, expect } from "@playwright/test";

const casos = [
  {
    cep: "80000000",
    valor: "199,99",
    valido: true,
    texto: "Frete: R$ 15,00",
    desc: "limite de frete pago para CEP iniciando com 8",
  },
  {
    cep: "10000000",
    valor: "199,99",
    valido: true,
    texto: "Frete: R$ 25,00",
    desc: "limite de frete pago para demais CEPs",
  },
  {
    cep: "80000000",
    valor: "200,00",
    valido: true,
    texto: "Frete grátis",
    desc: "limite exato para frete grátis (CEP 8)",
  },
  {
    cep: "10000000",
    valor: "200,00",
    valido: true,
    texto: "Frete grátis",
    desc: "limite exato para frete grátis (Demais CEPs)",
  },
  {
    cep: "80000000",
    valor: "0,01",
    valido: true,
    texto: "Frete: R$ 15,00",
    desc: "limite inferior do valor do pedido",
  },
  {
    cep: "81234567",
    valor: "100,00",
    valido: true,
    texto: "Frete: R$ 15,00",
    desc: "CEP genérico válido iniciado em 8",
  },
  {
    cep: "01234567",
    valor: "100,00",
    valido: true,
    texto: "Frete: R$ 25,00",
    desc: "CEP genérico válido não iniciado em 8",
  },
  {
    cep: "1234567",
    valor: "100,00",
    valido: false,
    texto: "Dados inválidos",
    desc: "CEP curto (7 dígitos)",
  },
  {
    cep: "123456789",
    valor: "100,00",
    valido: false,
    texto: "Dados inválidos",
    desc: "CEP longo (9 dígitos)",
  },
  {
    cep: "80000-00",
    valor: "100,00",
    valido: false,
    texto: "Dados inválidos",
    desc: "CEP com caracteres especiais",
  },
  {
    cep: "80000abc",
    valor: "100,00",
    valido: false,
    texto: "Dados inválidos",
    desc: "CEP com letras",
  },
  {
    cep: "80000000",
    valor: "0,00",
    valido: false,
    texto: "Dados inválidos",
    desc: "valor do pedido igual a zero",
  },
  {
    cep: "80000000",
    valor: "-10,00",
    valido: false,
    texto: "Dados inválidos",
    desc: "valor do pedido negativo",
  },
  {
    cep: "",
    valor: "100,00",
    valido: false,
    texto: "Dados inválidos",
    desc: "CEP vazio",
  },
  {
    cep: "80000000",
    valor: "",
    valido: false,
    texto: "Dados inválidos",
    desc: "valor do pedido vazio",
  },
];

test.describe("calculadora de frete", () => {
  for (const caso of casos) {
    test(`deve lidar com ${caso.desc}`, async ({ page }) => {
      await page.goto("/frete");

      await page.getByLabel("CEP").fill(caso.cep);
      await page.getByLabel("Valor do pedido").fill(caso.valor);
      await page.getByRole("button", { name: "Calcular frete" }).click();

      const resultado = page.locator("#resultado");
      await expect(resultado).toBeVisible();
      await expect(resultado).toHaveText(caso.texto);

      await expect(resultado).toHaveAttribute(
        "role",
        caso.valido ? "status" : "alert",
      );

      if (caso.valido) {
        await expect(resultado).toHaveClass("success");
      } else {
        await expect(resultado).toHaveClass("");
      }
    });
  }
});
