import './Header.css';
import {useState} from "react";
import {Link} from "react-router-dom";

function Header() {
    const [hamburgerStatus, setHamburgerStatus] = useState("");
    const [navMenuStatus, setNavMenuStatus] = useState("");

    function mobileMenu() {
        setHamburgerStatus(hamburgerStatus === "active" ? "" : "active");
        setNavMenuStatus(navMenuStatus === "active" ? "" : "active");
    }

    return (
        <header className="header">
            <nav className="navbar">
                <a href="#" className="nav-logo">WebDev.</a>
                <ul className={`nav-menu ${navMenuStatus}`}>
                    <li className="nav-item">
                        <Link className="nav-link" to="">Home</Link>
                    </li>
                    <li className="nav-item">
                        <Link className="nav-link" to="/login">Logout</Link>
                    </li>
                </ul>
                <div className={`hamburger ${hamburgerStatus}`}
                     onClick={mobileMenu}>
                    <span className="bar" />
                    <span className="bar" />
                    <span className="bar" />
                </div>
            </nav>
        </header>
    );
}

export default Header;
