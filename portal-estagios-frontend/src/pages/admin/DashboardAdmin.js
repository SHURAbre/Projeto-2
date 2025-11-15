import { useEffect, useState } from "react";
import { apiGet } from "../../api"; // ajusta caminho conforme sua estrutura

export default function DashboardAdmin() {
  const [dados, setDados] = useState({});
  const token = localStorage.getItem("token");

  useEffect(() => {
    async function load() {
      try {
        const d = await apiGet("/admin/dashboard", token);
        setDados(d);
      } catch (err) {
        console.error("ERRO ao buscar /admin/dashboard:", err);
        alert("Erro ao carregar dashboard (ver console).");
      }
    }
    load();
  }, []);

  return (
    <div style={{ padding: 20 }}>
      <h1>Dashboard Administrativo</h1>

      <p>Empresas cadastradas: {dados.empresas ?? ""}</p>
      <p>Estudantes cadastrados: {dados.estudantes ?? ""}</p>
      <p>Vagas abertas: {dados.vagasAbertas ?? ""}</p>
      <p>Vagas encerradas: {dados.vagasEncerradas ?? ""}</p>
    </div>
  );
}