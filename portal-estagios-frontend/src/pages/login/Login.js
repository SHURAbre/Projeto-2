import { useState } from "react";
import { useNavigate } from "react-router-dom";

export default function Login() {
  const [login, setLogin] = useState("");
  const [senha, setSenha] = useState("");
  const navigate = useNavigate();

  async function entrar(e) {
    e.preventDefault();

    const resp = await fetch("https://animated-pancake-r4gvx5vpwj9fw55g-8080.app.github.dev/auth/login", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ login, senha }),
    });

    if (!resp.ok) {
      alert("Login inválido");
      return;
    }

    const data = await resp.json();

    localStorage.setItem("token", data.token);
    localStorage.setItem("role", data.role);
    localStorage.setItem("usuario", data.login);

    // REDIRECIONAMENTO CORRETO
    if (data.role === "ROLE_ADMIN") {
      navigate("/admin");
    } else if (data.role === "ROLE_ESTUDANTE") {
      navigate("/estudante");
    } else if (data.role === "ROLE_EMPRESA") {
      navigate("/empresa");
    }
  }

  return (
    <div>
      <h2>Login</h2>
      <form onSubmit={entrar}>
        <input
          value={login}
          onChange={(e) => setLogin(e.target.value)}
          placeholder="Login"
        />
        <br />
        <input
          type="password"
          value={senha}
          onChange={(e) => setSenha(e.target.value)}
          placeholder="Senha"
        />
        <br />
        <button>Entrar</button>
      </form>
    </div>
  );
}