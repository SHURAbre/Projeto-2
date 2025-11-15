import { Link } from "react-router-dom";

export default function PainelEmpresa() {
  return (
    <div style={{ padding: 20 }}>
      <h1>Painel da Empresa</h1>

      <Link to="/empresa/cadastrar-vaga">Cadastrar vaga</Link>
      <br />
      <Link to="/empresa/minhas-vagas">Minhas vagas</Link>
    </div>
  );
}