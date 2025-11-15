export default function GerarCurriculo() {
  const token = localStorage.getItem("token");

  function gerar() {
    const id = prompt("Digite seu ID de estudante:");
    window.open(
      "http://localhost:8080/curriculos/" + id,
      "_blank"
    );
  }

  return (
    <div style={{ padding: 20 }}>
      <h1>Gerar Currículo em PDF</h1>

      <button onClick={gerar}>Baixar Currículo</button>
    </div>
  );
}