export default function ListContainer({ children }) {
  return (
    <div style={{
      flex: 1,
      backgroundColor: '#f0f0f0',
      padding: '1rem',
      borderRadius: '10px',
      overflowY: 'auto',
      maxHeight: '85vh',
      color: 'black'
    }}>
      {children}
    </div>
  );
}
