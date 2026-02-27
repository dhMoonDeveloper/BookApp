import "./globals.css";
import Link from "next/link";
import style from "./layout.module.css";

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="ko">
      <body>
          <div className={style.container}>
            <header>
                <Link href={"/"}>📚 도서 관리 시스템</Link>
            </header>
            <main>{children}</main>
            <footer>
                <div>제작 @donghyun</div>
            </footer>
          </div>
      </body>
    </html>
  );
}
