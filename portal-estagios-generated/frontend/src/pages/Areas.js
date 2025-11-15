import { useEffect, useState } from "react";

export default function Areas() {
  const [areas, setAreas] = useState([]);
  const [titulo, setTitulo] = useState("");
  const [descricao, setDescricao] = useState("");

  const API_URL = process.env.REACT_APP_API_URL || "http://localhost:8080";

  async function carregar() {
    try {
      const resp = await fetch(`${API_URL}/areas`);
      if (!resp.ok) throw new Error("Status " + resp.status);
      setAreas(await resp.json());
    } catch (e) {
      console.error("Erro ao carregar áreas:", e);
      alert("Erro ao carregar áreas. Veja console.");
    }
  }

  async function salvar() {
    try {
      const resp = await fetch(`${API_URL}/areas`, {
        method: "POST",
        headers: {"Content-Type":"application/json"},
        body: JSON.stringify({ titulo, descricao })
      });
      if (!resp.ok) throw new Error("Status " + resp.status);
      setTitulo(""); setDescricao("");
      carregar();
    } catch (e) {
      console.error("Erro ao salvar:", e);
      alert("Erro ao salvar área. Veja console.");
    }
  }

  async function deletar(id) {
    await fetch(`${API_URL}/areas/${id}`, { method: "DELETE" });
    carregar();
  }

  useEffect(() => { carregar(); }, []);

  return (
    <div style={{ padding: 20 }}>
      <h2>Áreas de Interesse (Frontend Skeleton)</h2>
      <input placeholder="Título" value={titulo} onChange={e=>setTitulo(e.target.value)} />
      <br/>
      <input placeholder="Descrição" value={descricao} onChange={e=>setDescricao(e.target.value)} />
      <br/>
      <button onClick={salvar}>Salvar</button>
      <hr/>
      <ul>
        {areas.map(a => (
          <li key={a.id}>
            <strong>{a.titulo}</strong> — {a.descricao}
            <button onClick={()=>deletar(a.id)} style={{marginLeft:10}}>Excluir</button>
          </li>
        ))}
      </ul>
    </div>
  );
}
