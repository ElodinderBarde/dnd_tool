import { useEffect, useState } from 'react';
import { getNpcs } from '../service/npcAPI';
import NpcList from '../components/npcs/NpcList';
import Navbar from '../components/navbar';

export default function NpcBoard() {
 

  return (
    
    <>
    <Navbar />
    <main style={{ padding: '2rem' }}>
      <h2>NPC Page</h2>
      <p>Bitte einen NPC auswählen.</p>    </main>
  </>
);
}
    
 

