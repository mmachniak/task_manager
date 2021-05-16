import {useErrorStatus} from "../components/ErrorHandler";
import {useEffect, useState} from "react";

export const useQuery = (url, defaultValue) => {
    const {setErrorStatusCode} = useErrorStatus();
    const [apiData, setApiData] = useState(defaultValue);
    useEffect( () => {
       fetch(url, {headers: {"Authorization" : "Bearer " + localStorage.getItem("token")}})
           .then(data => {
               if (data.status === 401) {
                   setErrorStatusCode(401);
                   return;
               }
               return data.json()}
           )
           .then((json) => {
               setApiData(json)
            })
    }, [url]);
    return {data: apiData};
}