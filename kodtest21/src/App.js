import React, { useState } from 'react';

/**
 * App
 *
 * Simple react js fetch example
 */
const App = () => {

    const [titles, setTitles] = useState([]);
    const [filteredTitles, setFilteredTitles] = useState([]);
    const [search, setSearch] = useState([]);
    const [searchQ, setSearchQ] = useState('');
    const [language, setLanguage] = useState('');
    const [genre, setGenre] = useState('');
    

    

    /**
     * get all titles from api
     */
    const loadTitles = async () => {

        const url = "http://localhost:8080/api/titles";
        const response = await fetch(url);
        const data = await response.json();
        setTitles(data);
        
    };

    /**
     * get all titles that match the genre and language
     * @param {*} genre genre of movie
     * @param {*} language language of movie
     */
    const filter = async (genre, language) => {
      const url = "http://localhost:8080/api/movies/filtered/?genre=" + genre + "&language=" + language;
      const response = await fetch(url);
      const data = await response.json();
      setFilteredTitles(data);
    }
    /**
     * A free search on title, plot, director, actor
     * @param {*} searchString  the free search
     */
    const searchMovies = async (searchString) => {
      const url = "http://localhost:8080/api/movies/search?searchString=" + searchString;
      const response = await fetch(url);
      const data = await response.json();
      let s = '';
      for(let i = 0; i < data.length; i++){
        s += data[i].title + ', ';
      }
      setSearch(s);
    }

    

    

    
    return (
          
            <div className="App">
                <ul>Availible titles:   
                    {titles}
                </ul>
                <button onClick={loadTitles}>list titles</button>
                <ul>
                <input type="text"  id="q" placeholder="language" name="search" 
                    onChange={(e) => setLanguage(e.target.value)}></input>
                    <input type="text"  id="q" placeholder="genre" name="search" 
                    onChange={(e) => setGenre(e.target.value)}></input>
                  <button onClick={() => filter(genre, language)}>filter</button>
                  {filteredTitles}
                </ul>
                <ul>
                  
                    <input type="text"  id="q" placeholder="Search.." name="search" 
                    onChange={(e) => setSearchQ(e.target.value)}></input>
                    <button onClick={() => searchMovies(searchQ)} type="submit">search</button>
                    
                  
                </ul>
                <ul>
                  searched titles: {search}
                </ul>
            </div>
           
    );

    }



export default App;