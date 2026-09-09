# App Login: Atividade de Layouts Android

**Autor:** Stefan Zanini

> Atividade: Criar Layouts - crie ao menos um layout para cada um dos tipos de layout
> a seguir: **ConstraintLayout**, **RelativeLayout**, **TableLayout** e
> **LinearLayout**.

Cada tipo ganhou uma tela própria, e uma tela de menu liga todas elas. O restante do
app (login, navegação) existe só para dar acesso às telas. Não há nenhuma
pretensão de ser um aplicativo real.

> **Aviso:** este app **não faz autenticação de verdade**. A tela de login não
> valida usuário nem senha: qualquer conteúdo (inclusive campos vazios) abre a
> tela seguinte. Isso é intencional: o foco da atividade são os layouts, não o
> login. Não use nada disso como referência de segurança.

## Como cada requisito foi atendido

| Requisito | Arquivo | Como foi resolvido |
|---|---|---|
| **ConstraintLayout**: ao menos três elementos (ex.: TextView, ImageView, Button) dispostos de maneira flexível e alinhados com o ConstraintLayout | `activity_constraint.xml` | Quatro elementos (`TextView`, `ImageView` e dois `Button`), todos posicionados por âncoras: encadeamento vertical com `layout_constraintTop_toBottomOf`, centralização horizontal entre `layout_constraintStart_toStartOf` e `layout_constraintEnd_toEndOf`, e o botão *Voltar* preso em `layout_constraintBottom_toBottomOf="parent"` |
| **RelativeLayout**: elementos posicionados em relação uns aos outros ou ao pai | `activity_relative.xml` | Usa as duas formas. Em relação ao **pai**: `layout_centerHorizontal`, `layout_centerInParent`, `layout_alignParentBottom`. Em relação aos **irmãos**: `layout_below` e `layout_alignStart` apontando para o texto central, e `layout_above` apontando para o botão *Voltar* |
| **TableLayout**: informações em formato tabular, podendo ser dados fictícios | `activity_table.xml` | Quatro `TableRow` com `stretchColumns="*"`: uma linha de cabeçalho (Nome / Idade / Cidade, em negrito) e três linhas de dados fictícios (Ana, Bruno e Carla) |
| **LinearLayout**: elementos organizados em uma única direção, horizontal ou vertical | `activity_linear.xml` | `orientation="vertical"`, empilhando um título, três itens de texto e dois botões, espaçados por `layout_marginTop`. As telas de login e de menu também usam `LinearLayout` vertical |

## Ciclo de vida da Activity

A `MainActivity` sobrescreve os sete métodos do ciclo de vida e registra cada um
no Logcat com a tag `MainActivity`:

```
onCreate  -> onStart -> onResume -> onPause -> onStop -> onRestart -> onDestroy
```

Para acompanhar, filtre o Logcat pela tag `MainActivity` e alterne entre as telas,
gire o dispositivo ou envie o app para segundo plano.

## Como executar

1. Abrir o projeto no Android Studio.
2. Selecionar um emulador ou dispositivo com **API 36 ou superior**.
3. *Run* (`Shift + F10`).

## Configuração técnica

| Item | Valor |
|---|---|
| Linguagem | Kotlin (compilado pelo suporte nativo do AGP 9, sem plugin Kotlin separado) |
| `namespace` / `applicationId` | `br.com.example.login` |
| `compileSdk` | 37 |
| `minSdk` | 36 |
| `targetSdk` | 36 |
| Android Gradle Plugin | 9.3.1 |
| Gradle | 9.5.0 |
| Java | 11 |
| Tema | `Theme.MaterialComponents.DayNight.DarkActionBar` |

> O `compileSdk` fica em 37 porque `androidx.core:core-ktx:1.19.0` exige compilar
> contra a API 37. Isso não limita a instalação: quem define os aparelhos
> compatíveis é o `minSdk`, que está em 36.

## Estrutura

```
app/src/main/
├── AndroidManifest.xml
├── java/br/com/example/login/
│   ├── MainActivity.kt          # login (sem validação) + logs de ciclo de vida
│   ├── HomeActivity.kt          # menu de navegação
│   ├── ConstraintActivity.kt
│   ├── RelativeActivity.kt
│   ├── TableActivity.kt
│   └── LinearActivity.kt
└── res/
    ├── layout/                  # um XML por tela
    ├── values/                  # colors, strings, themes
    └── values-night/            # tema escuro
```
