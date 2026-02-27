"use client";

import { useState } from "react";
import style from "./serachbar.module.css";
import { useRouter, useSearchParams } from "next/navigation";

export default function Searchbar() {

    const router = useRouter();
    const searchParams = useSearchParams();
    const q = searchParams.get("q") || "";
    const [search, setSearch] = useState<string>(q);

    const onChangeSearch = (e : React.ChangeEvent<HTMLInputElement>) => {
        setSearch(e.target.value); 
    }

    const onSubmit = () => {
        if(q === search) return; // 검색조건이 그대로인 경우 

        if(!search) {
            router.push("/");
            return;
        }

        router.push(`/search?q=${search}`);
    }

    const onKeyDown = (e : React.KeyboardEvent<HTMLInputElement>) => {
        if(e.key === "Enter") {
            onSubmit();
        }
    }

    return (
        <div className={style.container}>
            <input 
                value={search}
                onChange={onChangeSearch}    
                onKeyDown={onKeyDown}
            />
            <button onClick={onSubmit}>검색</button>
        </div>
    );
}
