const sqlite3 = require('sqlite3').verbose();
const express = require('express');
const bodyParser = require('body-parser');

const app = express();
const PORT=process.env.PORT || 3000



// Create database
const db = new sqlite3.Database('./database/employees.db');



db.run('CREATE TABLE IF NOT EXISTS items(id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT,description TEXT,color TEXT)');

app.use(bodyParser.urlencoded({extended: true}));
app.use(express.static('public'));

app.get('/', (req,res)=>{
    res.sendFile(__dirname + './public/create.html');
  });
  
  
  // Insert
  app.post('/submit', (req,res)=>{
    const {title,description,color}=req.body;
    
      db.run('INSERT INTO items(title,description,color) VALUES(?,?,?)',
        [title, description, color], (err)=> {
        if (err) {
          return res.status(500).send('Internal Server Error');
        }
        console.log("New note has been created");
        res.send("New note has been added into the database with Title = "
          + req.body.title+ " and Description = " + req.body.description + " and Color = " + req.body.color);
      });
    });

  app.listen(PORT,()=>{ 
    console.log("Server listening on port: 3000");
});
