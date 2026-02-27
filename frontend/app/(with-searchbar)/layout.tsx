import Searchbar from "../components/searchbar";

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
        <div>
          <Searchbar />
          {children}
        </div>
  );
}
