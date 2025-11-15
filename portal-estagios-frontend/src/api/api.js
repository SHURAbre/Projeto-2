import axios from "axios";

const BASE = "https://animated-pancake-r4gvx5vpwj9fw55g-8080.app.github.dev";

const api = axios.create({
  baseURL: BASE,
});

export async function apiGet(path, token) {
  const resp = await api.get(path, {
    headers: { Authorization: token ? `Bearer ${token}` : undefined },
  });
  return resp.data;
}

export async function apiPost(path, body, token) {
  const resp = await api.post(path, body, {
    headers: { Authorization: token ? `Bearer ${token}` : undefined },
  });
  return resp.data;
}

export default api;