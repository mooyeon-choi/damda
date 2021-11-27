import axios from "axios";

const API_URL = 'http://localhost:8000/api/auth/';
// multipart/form-data
class AuthService {
    login(username: string, password: string) {   
        return axios
          .post(API_URL + "signin", {username, password})
          .then(response => { if (response.data.accessToken) {
              localStorage.setItem("user", JSON.stringify(response.data));
            }
    
            return response.data;
        });
    }
    
    logout() {
        localStorage.removeItem("user");
    }

    register(username: string, password: string) {
        return axios.post(API_URL + "signup", {username, password});
    }

    getCurrentUser() {
        const userInfo = localStorage.getItem("user");
        if (userInfo) return JSON.parse(userInfo);

        return null;
    }
}

export default new AuthService();