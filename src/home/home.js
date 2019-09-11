import React from 'react';
import './home.css';
//displays the images on the page through a table
const Home = () => {
  return (
    <div>
      <body className="App-home">
        <h1><a id="home">Home</a></h1>
        <h2>Welcome to the guitar buyer's haven!</h2>
        <p>Here are the new products:</p>
        <table className="table_id">
          <tr>
            <th>New Guitars</th>
          </tr>
          <tr>
            <td>
              <img src="https://images.samash.com/sa/YF3/YF325DGUITAR.fpx?cvt=jpg"
                alt="Acoustic Guitar" height="200" width="500" />
            </td>
            <td>
              <img src="https://megamusic.blob.core.windows.net/images/0000250_ibanez-rg370ahmz-bmt-electric-guitar.jpg"
                alt="Electric Guitar" height="200" width="500" />
            </td>
            <td>
              <img src="data:image/jpeg;base64,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"
                alt="Acoustic Guitar" height="200" width="500" />
            </td>
            <td>
              <img src="https://cdn.shopify.com/s/files/1/1682/1021/files/webpage17_1024x.jpg?v=1517025590"
                alt="Acoustic Guitar" height="200" width="500" />
            </td>
            <td>
              <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ02pNw4BTUCCnCPaxBkUEo9Ikvw6q2lBCtLZMu5y2yqx2Hns7s"
                alt="Acoustic Guitar" height="200" width="500" />
            </td>
            <td>
              <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ3yFJU9zdItvGYuNnv5Oy6SOjn9X6HvJn9CK5jfRoTfE5wKEoEuA"
                alt="Acoustic Guitar" height="200" width="500" />
            </td>
            <td>
              <img src="https://nikhuber-guitars.com/images/1500_dolphin_splitblue_hero.jpg?crc=371207407"
                alt="Acoustic Guitar" height="200" width="500" />
            </td>
            <td>
              <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT_obghGimqNXNzZJjLEqmX0MiKKb2QXV8vEwVXLJspT5_soKrjsg"
                alt="Acoustic Guitar" height="200" width="500" />
            </td>
            <td>
              <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTy_hs59TBdOsZ6hz5O9DfC4Uhjkl_Kq24hyWb4RC7xMHntvMIz"
                alt="Acoustic Guitar" height="200" width="500" />
            </td>
            <td>
              <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXiRLllLsw98PVeC2H2n7BAcK0872V2B6NaNgB5K8IItLnO9WC"
                alt="Acoustic Guitar" height="200" width="500" />
            </td>
            <td>
              <img src="http://classicalguitar101.org/images/plain-guitar.jpg"
                alt="Acoustic Guitar" height="200" width="500" />
            </td>
            <td>
              <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTDyf7gBHtviFFzqaaLYfMepeL4O2Am9Ou-77kLTHws954dpSUvlQ"
                alt="Acoustic Guitar" height="200" width="500" />
            </td>
          </tr>
        </table>
      </body>
    </div>
  );
}

export default Home;