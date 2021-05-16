import React, {useEffect, useState, createContext, useMemo, useContext} from "react";
import {useHistory} from "react-router-dom";
import Login from "../pages/Login";


const ErrorStatusContext = createContext(undefined);


export const ErrorHandler = ({children}) => {

    const history = useHistory();
    const [errorStatusCode, setErrorStatusCode] = useState();

    useEffect(
        () => {
            return history.listen(() => setErrorStatusCode(undefined));
        }, [history]
    )

    const renderContent = () => {
        if (errorStatusCode === 401) {
            return <Login/>;
        }
        return children;
    }

    const contextPayload = useMemo(
        () => ({setErrorStatusCode}),
        [setErrorStatusCode]
    );

    return (<ErrorStatusContext.Provider value={contextPayload}>
        {renderContent()}
    </ErrorStatusContext.Provider>);

}

export const useErrorStatus = () => useContext(ErrorStatusContext);