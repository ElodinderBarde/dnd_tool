import { Link } from 'react-router-dom';
import './components_css/navbar.css'; 

export default function Navbar() {
  return (
    <header className="navbar">
      <nav className="nav">
        <Link to="/">Home</Link>
        <Link to="/generator">Generator</Link>
        <Link to="/clan">Clan</Link>
        <Link to="/monster">Monster</Link>
        <Link to="/shops">Shops</Link>
        <Link to="/players">Players</Link>
        <Link to="/quests">Questboard</Link>
        <Link to="/NpcBoard">NPC's</Link>
        <Link to="/Itemboard">Itemboard</Link>
        <Link to="/World">Welt</Link>
        
        
        
        
             </nav>
    </header>
  );
}
