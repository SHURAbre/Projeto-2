import { Link } from "react-router-dom";

export default function PainelEstudante() {
  return (
    <div style={{ padding: 20 }}>
      <h1>Painel do Estudante</h1>

      <Link to="/estudante/vagas">Vagas recomendadas</Link>
      <br />
      <Link to="/estudante/pdf">Gerar currículo em PDF</Link>
    </div>
  );
}