import axios from 'axios';

const axiosApiInstance = axios.create({
    baseURL: `http://localhost:8080/`
});


// Request interceptor for API calls
axiosApiInstance.interceptors.request.use(
    async config => {
        config.headers = {
            'Authorization': `Bearer ${localStorage.getItem('token')}`,
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
        return config;
    },
    error => {
        return Promise.reject(error)
    });

axiosApiInstance.interceptors.response.use((response) => {
    return response.data;
}, async function (error) {
    return Promise.reject(error);
});


export default axiosApiInstance;