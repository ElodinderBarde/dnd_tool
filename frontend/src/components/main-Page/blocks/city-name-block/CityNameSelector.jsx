import "./CityNameSelector.css";

export default function CityNameSelector({ selectedLocation, onOpen }) {
    return (
        <div className="block-content">
            <h3>
                {selectedLocation
                    ? selectedLocation.cityName ?? selectedLocation.villageName
                    : "City Name"}
            </h3>

            <button type="button" onClick={onOpen}>
                Ortschaften
            </button>
        </div>
    );
}
