import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";

import Login from "./pages/login/Login";
import DashboardAdmin from "./pages/admin/DashboardAdmin";
import PainelEstudante from "./pages/estudante/PainelEstudante";
import VagasRecomendadas from "./pages/estudante/VagasRecomendadas";
import GerarCurriculo from "./pages/estudante/GerarCurriculo";
import PainelEmpresa from "./pages/empresa/PainelEmpresa";
import CadastrarVaga from "./pages/empresa/CadastrarVaga";
import ListaVagasEmpresa from "./pages/empresa/ListaVagasEmpresa";
import Areas from "./pages/areas/Areas";

import RequireRole from "./RequireRole";

function App() {
  return (
    <BrowserRouter>
      <Routes>

        {/* Redireciona / para /login */}
        <Route path="/" element={<Navigate to="/login" />} />

        {/* Login */}
        <Route path="/login" element={<Login />} />

        {/* Admin */}
        <Route path="/admin" element={
          <RequireRole role="ROLE_ADMIN">
            <DashboardAdmin />
          </RequireRole>
        }/>

        <Route path="/areas" element={
          <RequireRole role="ROLE_ADMIN">
            <Areas />
          </RequireRole>
        }/>

        {/* Estudante */}
        <Route path="/estudante" element={
          <RequireRole role="ROLE_ESTUDANTE">
            <PainelEstudante />
          </RequireRole>
        }/>

        <Route path="/estudante/vagas" element={
          <RequireRole role="ROLE_ESTUDANTE">
            <VagasRecomendadas />
          </RequireRole>
        }/>

        <Route path="/estudante/pdf" element={
          <RequireRole role="ROLE_ESTUDANTE">
            <GerarCurriculo />
          </RequireRole>
        }/>

        {/* Empresa */}
        <Route path="/empresa" element={
          <RequireRole role="ROLE_EMPRESA">
            <PainelEmpresa />
          </RequireRole>
        }/>

        <Route path="/empresa/cadastrar-vaga" element={
          <RequireRole role="ROLE_EMPRESA">
            <CadastrarVaga />
          </RequireRole>
        }/>

        <Route path="/empresa/minhas-vagas" element={
          <RequireRole role="ROLE_EMPRESA">
            <ListaVagasEmpresa />
          </RequireRole>
        }/>

      </Routes>
    </BrowserRouter>
  );
}

export default App;