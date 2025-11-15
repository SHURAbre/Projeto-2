import { useEffect, useState } from "react";
import { apiGet } from "../../api";

export default function ListaVagasEmpresa() {
  const [vagas, setVagas] = useState([]);
  const token = localStorage.getItem("token");

  useEffect(() => {
    async function load() {
      const lista = await apiGet("/vagas", token);
      setVagas(lista);
    }
    load();
  }, []);

  return (
    <div style={{ padding: 20 }}>
      <h1>Minhas Vagas</h1>

      <ul>
        {vagas.map(v => (
          <li key={v.id}>{v.titulo}</li>
        ))}
      </ul>
    </div>
  );
}