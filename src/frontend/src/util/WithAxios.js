import {useMemo} from 'react'
import {useErrorStatus} from "../components/ErrorHandler";
import axiosApiInstance from "./axiosApiInstance";

const WithAxios = ({children}) => {
    const {setErrorStatusCode} = useErrorStatus();

    useMemo(() => {
        axiosApiInstance.interceptors.response.use((response) => {
                return response;
            },
            async (error) => {
                setErrorStatusCode(401);
                return Promise.reject(error);
            })
    }, [setErrorStatusCode])

    return children
}

export default WithAxios;