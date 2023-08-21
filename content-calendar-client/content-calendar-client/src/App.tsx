import { useEffect, useState } from "react";
import "./App.css";

interface ContentItem {
  id: number;
  title: string;
  status: string;
  desc: string;
  contentType: string;
  dateCreated: string;
  dateUpdated: string | null;
  url: string;
}

export default function App() {
  const [loading, setLoading] = useState(true);
  const [data, setData] = useState<ContentItem[]>([]);
  useEffect(() => {
    const fetchContent = async () => {
      try {
        const response = await fetch("http://localhost:8080/api/content", {
          method: "GET",
        });
        if (!response.ok) {
          throw new Error(`HTTP error! Status: ${response.status}`);
        }
        const jsonList = await response.json();
        setData(jsonList);
      } catch (err: unknown) {
        if (err instanceof Error) {
          console.log(err.message);
        } else {
          console.log("Some erro message!");
        }
        setData([]);
      } finally {
        setLoading(false);
      }
    };
    fetchContent();
  }, []);

  const listItems = data.map((c) => (
    <li key={crypto.randomUUID()}>{JSON.stringify(c)}</li>
  ));
  return (
    <>
      <ul>{!loading ? listItems : "no content to show"}</ul>
    </>
  );
}
