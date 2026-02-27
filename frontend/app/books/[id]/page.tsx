import style from "./page.module.css";

type BookDetailProps = { bookId : string };

async function BookDetail({ bookId } :  BookDetailProps) {
    const response = await fetch(`${process.env.NEXT_PUBLIC_API_BASE_URL}/api/books/${bookId}`);
    const book = await response.json();

    const { title, subTitle, content, author, createdAt , coverImageUrl } = book;

    return     (
        <div className={style.container}>
        <div
            className={style.cover_img_container}
            style={{ backgroundImage: `url('${coverImageUrl}')` }}
        >
            <img src={coverImageUrl} />
        </div>
        <div className={style.title}>{title}</div>
        <div className={style.subTitle}>{subTitle}</div>
        <div className={style.author}>
            {author}
        </div>
        <div className={style.description}>{content}</div>
        </div>
    )
    
}


export default async function Page({
  params,
}: {
  params: Promise<{id: string}>;
}) {

    const { id } = await params;

    return <div>
            <BookDetail bookId={id}/>
            </div>
}