import Navbar from '../components/navbar';
import '../components/items/layout/itemboard.css';
import ItemForm from '../components/items/ItemForm';
import ResourceFilter from '../components/items/ResourceFilter';
import ItemList from '../components/items/ItemList';
import ItemContainer from '../components/items/layout/ItemContainer';
import ListContainer from '../components/items/layout/ListContainer';
import FilterContainer from '../components/items/layout/filterContainer';
import ItemDetail from '../components/items/itemDetail';

import { useEffect, useState } from 'react';
import { getItems } from '../service/itemAPI';

export default function Itemboard() {
  const [allItems, setAllItems] = useState([]);
  const [filteredItems, setFilteredItems] = useState([]);
  const [selectedItem, setSelectedItem] = useState(null);

  useEffect(() => {
    getItems()
      .then((data) => {
        setAllItems(data);
        setFilteredItems(data);
      })
      .catch(console.error);
  }, []);

  const handleFilterChange = ({ buch, typ, sort }) => {
    let filtered = [...allItems];

    if (buch) filtered = filtered.filter(item => item.buch === buch);
    if (typ) filtered = filtered.filter(item => item.typ === typ);

    switch (sort) {
      case 'price-asc': filtered.sort((a, b) => a.price - b.price); break;
      case 'price-desc': filtered.sort((a, b) => b.price - a.price); break;
      case 'alpha-asc': filtered.sort((a, b) => a.name.localeCompare(b.name)); break;
      case 'alpha-desc': filtered.sort((a, b) => b.name.localeCompare(a.name)); break;
    }

    setFilteredItems(filtered);
  };

  return (
    <>
      <Navbar />
      <div className="itemboard-wrapper">
        <div className="left-column">
          <ItemContainer>
            <ItemForm />
          </ItemContainer>
  
          <FilterContainer>
            <ResourceFilter onFilterChange={handleFilterChange} />
          </FilterContainer>
        </div>
  
        <div className="right-column">
          <ListContainer>
          <ItemList items={filteredItems} onSelect={setSelectedItem} />
          </ListContainer>
        </div>
        <ItemDetail item={selectedItem} />
      </div>
    </>
  );
  
}
