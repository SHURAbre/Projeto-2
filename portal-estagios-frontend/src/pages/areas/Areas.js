import { useEffect, useState } from "react";

export default function Areas() {
  const [areas, setAreas] = useState([]);
  const [titulo, setTitulo] = useState("");
  const [descricao, setDescricao] = useState("");

  const token = localStorage.getItem("token");

  const API_URL = "https://animated-pancake-r4gvx5vpwj9fw55g-8080.app.github.dev";

  async function carregar() {
    const resp = await fetch(`${API_URL}/areas`, {
      headers: {
        Authorization: "Bearer " + token,
      },
    });

    console.log("STATUS LISTAGEM:", resp.status);

    if (!resp.ok) {
      console.log("Erro ao carregar áreas");
      return;
    }

    const data = await resp.json();
    setAreas(data);
  }

  async function salvar() {
    const resp = await fetch(`${API_URL}/areas`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: "Bearer " + token,
      },
      body: JSON.stringify({ titulo, descricao }),
    });

    console.log("STATUS SALVAR:", resp.status);

    const txt = await resp.text();
    console.log("RESPOSTA DO BACKEND:", txt);

    if (!resp.ok) {
      alert("Erro ao salvar área");
      return;
    }

    setTitulo("");
    setDescricao("");
    carregar();
  }

  async function deletar(id) {
    const resp = await fetch(`${API_URL}/areas/${id}`, {
      method: "DELETE",
      headers: {
        Authorization: "Bearer " + token,
      },
    });

    console.log("STATUS DELETE:", resp.status);

    carregar();
  }

  useEffect(() => {
    carregar();
  }, []);

  return (
    <div style={{ padding: 20 }}>
      <h1>Áreas de Interesse</h1>

      <h3>Cadastrar nova área:</h3>
      <input
        placeholder="Título"
        value={titulo}
        onChange={(e) => setTitulo(e.target.value)}
      />
      <br />

      <input
        placeholder="Descrição"
        value={descricao}
        onChange={(e) => setDescricao(e.target.value)}
      />
      <br />

      <button onClick={salvar}>Salvar</button>

      <hr />

      <h3>Lista de áreas cadastradas:</h3>

      <ul>
        {areas.map((a) => (
          <li key={a.id}>
            <strong>{a.titulo}</strong> – {a.descricao}
            <button
              style={{ marginLeft: 10 }}
              onClick={() => deletar(a.id)}
            >
              Excluir
            </button>
          </li>
        ))}
      </ul>
    </div>
  );
}