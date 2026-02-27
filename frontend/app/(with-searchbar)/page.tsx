
import BookItem from "../components/book-item";
import { BookData } from "../types/types";

async function AllBooks() {

    const resData = await fetch(`${process.env.NEXT_PUBLIC_API_BASE_URL}/api/books`)

    const allBooks: BookData[] = await resData.json();
    return (
      <div>
        {allBooks.map((book) => (
            <BookItem key={book.id} book={book} />
        ))}
      </div>
  )
}

async function RandomBooks() {

    const resData = await fetch(`${process.env.NEXT_PUBLIC_API_BASE_URL}/api/books/random?limit=1`);

    const randomBooks : BookData[] = await resData.json();
    return (
      <div>
        {randomBooks.map((book) => (
            <BookItem key={book.id} book={book} />
        ))}
      </div>
  )

}

export default function Home() {
  return (
      <div>
          <section>
            <h3>추천 도서(Random)</h3>
            <RandomBooks />
          </section>
          <section>
            <h3>등록된 모든 도서</h3>
              <AllBooks />
            </section>
      </div>
  );
}
