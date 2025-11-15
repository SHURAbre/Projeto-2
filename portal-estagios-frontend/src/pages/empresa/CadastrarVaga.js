import { useState } from "react";
import { apiPost } from "../../api";

export default function CadastrarVaga() {
  const [titulo, setTitulo] = useState("");
  const [descricao, setDescricao] = useState("");
  const token = localStorage.getItem("token");

  async function salvar() {
    await apiPost("/vagas", { titulo, descricao }, token);
    alert("Vaga cadastrada!");
  }

  return (
    <div style={{ padding: 20 }}>
      <h1>Cadastrar Vaga</h1>

      <input placeholder="Título" onChange={e => setTitulo(e.target.value)} />
      <br />
      <textarea 
        placeholder="Descrição" 
        onChange={e => setDescricao(e.target.value)}
      />
      <br />
      <button onClick={salvar}>Salvar</button>
    </div>
  );
}