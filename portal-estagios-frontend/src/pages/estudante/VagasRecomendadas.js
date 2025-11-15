import { useEffect, useState } from "react";
import { apiGet, apiPost } from "../../api";

export default function VagasRecomendadas() {
  const [vagas, setVagas] = useState([]);
  const token = localStorage.getItem("token");

  useEffect(() => {
    async function load() {
      const lista = await apiGet("/vagas/abertas", token);
      setVagas(lista);
    }
    load();
  }, []);

  async function inscrever(id) {
    await apiPost("/inscricoes", { vaga: { id } }, token);
    alert("Inscrição realizada!");
  }

  return (
    <div style={{ padding: 20 }}>
      <h1>Vagas Recomendadas</h1>

      <ul>
        {vagas.map(v => (
          <li key={v.id}>
            <strong>{v.titulo}</strong> — {v.modalidade}
            <button onClick={() => inscrever(v.id)}>Inscrever</button>
          </li>
        ))}
      </ul>
    </div>
  );
}