import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import 'gridstack/dist/gridstack.min.css';
import Main from './pages/main';
import Clan from './pages/clan';
import Generator from './pages/generator';
import Monster from './pages/monster';
import NpcBoard from './pages/NpcBoard';
import Shops from './pages/shops';
import Quests from './pages/quests';
import Players from './pages/players';
import Itemboard from './pages/Itemboard';
import ErrorPage from './pages/errorhandling';
import ShopDetails from "./pages/shop-details.jsx";


function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Main />} />
        <Route path="/clan" element={<Clan />} />
        <Route path="/generator" element={<Generator />} />
        <Route path="/monster" element={<Monster />} />
        <Route path="/NpcBoard" element={<NpcBoard />} />
        <Route path="/shops" element={<Shops />} />
        <Route path="/quests" element={<Quests />} />
        <Route path="/players" element={<Players />} />
        <Route path="/itemboard" element={<Itemboard />} />
        <Route path="/*" element={<ErrorPage />} />
        <Route path="/shops/:shopId" element={<ShopDetails />} />





      </Routes>
    </Router>
  );
}

export default App;
