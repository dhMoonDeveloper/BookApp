import Link from "next/link";
import { BookData } from "../types/types";
import style from "./book-item.module.css";

type Props = {
    book : BookData;
};

export default function BookItem({ book } : Props) {
    return (
        <Link href={`/books/${book.id}`} className={style.container}>
        <img src={book.coverImageUrl} />
        <div>
            <div className={style.title}>{book.title}</div>
            <div className={style.subTitle}>{book.subTitle}</div>
            <br />
            <div className={style.author}>
                {book.author}
            </div>
        </div>
        </Link>
    )
}