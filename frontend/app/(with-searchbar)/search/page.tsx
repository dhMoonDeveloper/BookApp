import BookItem from "@/app/components/book-item";
import { BookData } from "@/app/types/types";

async function SearchResult({
    q 
} : {q : string }) {
    const resData = fetch(`${process.env.NEXT_PUBLIC_API_BASE_URL}/api/books/search?q=${q}`);

    const books : BookData[] = await (await resData).json();

    return (
        <div>
            {books.map((book) => <BookItem key={book.id} book={book} />)}
        </div>
    )
}

export default async function Page({
    searchParams
} : { searchParams : Promise<{ q : string }>}) {

    const {q} = await searchParams;

    return <SearchResult q = {q} />
}