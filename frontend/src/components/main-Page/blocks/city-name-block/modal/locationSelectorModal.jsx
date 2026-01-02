"use client";
import { Separator } from "@/components/ui/separator";
import { DialogContent } from "@/components/ui/dialog";

import { useEffect, useState } from "react";
import { IconMapPin } from "@tabler/icons-react";

import {
    Command,
    CommandDialog,
    CommandEmpty,
    CommandGroup,
    CommandInput,
    CommandItem,
    CommandList,
} from "@/components/ui/command";

import { getLocation } from "@/service/locationAPI.js";

export function CommandMenu01({ open, setOpen, onSelectLocation }) {
    const [cities, setCities] = useState([]);
    const [villages, setVillages] = useState([]);

    const handleSelect = (location) => {
        onSelectLocation(location);
        setOpen(false);
    };

    useEffect(() => {
        async function loadLocations() {
            const locations = await getLocation();
            setCities(locations.filter(l => l.cityName));
            setVillages(locations.filter(l => l.villageName));
        }
        loadLocations();
    }, []);

    return (
        <CommandDialog open={open} onOpenChange={setOpen}>
            <DialogContent
                className="max-w-[900px] w-[90vw] h-[80vh] p-4"
            >
                <Command className="h-full flex flex-col">

                    {/* sauberer Abstand nach oben */}
                    <div className="pt-6"  />

                   <br/>
                   <br/>


                    <CommandInput
                        placeholder="Stadt oder Dorf suchen…"
                        className="border-b mb-3"
                    />

                    <div
                        className="flex-1 overflow-y-auto"
                        onWheel={(e) => e.stopPropagation()}
                    >
                        <CommandList className="max-h-none">
                            <CommandEmpty>Keine Ergebnisse gefunden.</CommandEmpty>

                            <CommandGroup heading="Städte">
                                <Separator className="my-2" />
                                {cities.map((city) => (
                                    <CommandItem
                                        key={city.locationId}
                                        onSelect={() => handleSelect(city)}
                                    >
                                        <IconMapPin className="mr-2 h-5 w-5" />
                                        {city.cityName}
                                    </CommandItem>
                                ))}
                            </CommandGroup>

                            <CommandGroup heading="Dörfer">
                                <Separator className="my-2" />
                                {villages.map((village) => (
                                    <CommandItem
                                        key={village.locationId}
                                        onSelect={() => handleSelect(village)}
                                    >
                                        <IconMapPin className="mr-2 h-5 w-5" />
                                        {village.villageName}
                                    </CommandItem>
                                ))}
                            </CommandGroup>
                        </CommandList>
                    </div>

                </Command>
            </DialogContent>
        </CommandDialog>


    );
}
