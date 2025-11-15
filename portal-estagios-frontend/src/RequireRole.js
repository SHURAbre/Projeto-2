import { Navigate } from "react-router-dom";

export default function RequireRole({ children, role }) {
  const token = localStorage.getItem("token");
  const perfil = localStorage.getItem("role");

  if (!token) return <Navigate to="/login" />;

  if (role && perfil !== role) return <Navigate to="/login" />;

  return children;
}