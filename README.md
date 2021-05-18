# ProjetoDesignPatterns


Tema: Como verificar em um cadastro de pessoas se foram vacinadas ou não.

Atributos
Pessoas (nome, data de nascimento, tel, idade, cpf, email)
Grupos Prioridades (descrição, nome, codigo)


  
  #### Back_End
>>
---
1. Linguagem: Java
2. JDK e je: 11
3. Maven
4. JAR
5. Banco POSTGRE
6. pgAdmin4
7. POSTMAN
8. IDE:SpringTools4/SpringBoot
9. Projeto STS usou as seguintes libs: 
  1.Spring data JPA
  2.PostgreSQL Driver
  3.Spring Boot Dev tools
  4.Spring Web

*Características*
Rest API's
Uso de JSON 
Protocolo HTTP: Métodos usados--> GET(recupera atributo), POST (armazena), PUT(atualiza informações),DELETE(remove),  PATCH(atualiza só o que foi mudado)
Endpoints(endereço : localhost:8080/pessoa)


***
  
  #### Passo a Passo - Springboot
  >>
---
  ![image]( https://github.com/robertacristinaabreu01/ProjetoDesignPatterns/blob/main/GIT_DP_EVacccine/DP_1.png)
  
  >>
  ---
  
  ![image](https://github.com/robertacristinaabreu01/ProjetoDesignPatterns/blob/main/GIT_DP_EVacccine/DP_2.png)
  
  >>
  ---
  
  ![image](https://github.com/robertacristinaabreu01/ProjetoDesignPatterns/blob/main/GIT_DP_EVacccine/DP_3.png)
  
  >>
  ---
  
  ![image](https://github.com/robertacristinaabreu01/ProjetoDesignPatterns/blob/main/GIT_DP_EVacccine/dp_4.png)
  
  >>
  ---
  
  ![image](https://github.com/robertacristinaabreu01/ProjetoDesignPatterns/blob/main/GIT_DP_EVacccine/DP_5.png)
  
  >>
  ---
  
  
  ![image](https://github.com/robertacristinaabreu01/ProjetoDesignPatterns/blob/main/GIT_DP_EVacccine/DP_6.png)
  
  >>
  ---
  
  
  ![image](https://github.com/robertacristinaabreu01/ProjetoDesignPatterns/blob/main/GIT_DP_EVacccine/DP_7.png)
  
  >>
  ---
  
  ![image](https://github.com/robertacristinaabreu01/ProjetoDesignPatterns/blob/main/GIT_DP_EVacccine/DP_8.png)
  
  
  >>
  ---
  
  
  ![image](https://github.com/robertacristinaabreu01/ProjetoDesignPatterns/blob/main/GIT_DP_EVacccine/DP_9.png)
  
  
  
  
  
  ***

#### Front-End
>>
---
React e React Native

criação projeto web
npx create-react-app <nomeProjeto>
cd <nomeProjeto>
npm start
  
usei a biblioteca Ant para CSS
usei a biblioteca axios para requisição HTPP para API

index.html, usei template da Plataforma Ant
criei na pasta src , duas pastas(PessoaDataService e Components)
 
  ***
  
  
  #### index.html
  
  ```
  {
  <!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <link rel="icon" href="%PUBLIC_URL%/favicon.ico" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta name="theme-color" content="#000000" />
    <meta
      name="description"
      content="Web site created using create-react-app"
    />
    <link rel="apple-touch-icon" href="%PUBLIC_URL%/logo192.png" />
    <!--
      manifest.json provides metadata used when your web app is installed on a
      user's mobile device or desktop. See https://developers.google.com/web/fundamentals/web-app-manifest/
    -->
    <link rel="manifest" href="%PUBLIC_URL%/manifest.json" />
    <!--
      Notice the use of %PUBLIC_URL% in the tags above.
      It will be replaced with the URL of the `public` folder during the build.
      Only files inside the `public` folder can be referenced from the HTML.

      Unlike "/favicon.ico" or "favicon.ico", "%PUBLIC_URL%/favicon.ico" will
      work correctly both with client-side routing and a non-root public URL.
      Learn how to configure a non-root public URL by running `npm run build`.
    -->
    <title>eVaccine</title>
  </head>
  <body>
    <noscript>You need to enable JavaScript to run this app.</noscript>
    <div id="root"></div>
    <!--
      This HTML file is a template.
      If you open it directly in the browser, you will see an empty page.

      You can add webfonts, meta tags, or analytics to this file.
      The build step will place the bundled scripts into the <body> tag.

      To begin the development, run `npm start` or `yarn start`.
      To create a production bundle, use `npm run build` or `yarn build`.
    -->
  </body>
</html>

  
  }
  
  ```
  
  #### Componentes/ListaPessoas.js
  
  ```
  {
  import { Button, Table, message} from 'antd';
import React, {Component}from 'react';
import PessoaDataService from '../services/PessoaDataService';

const {Column} = Table;

export default class ListaPessoas extends Component{

    constructor(props){
        super(props)
        this.state = {
                pessoas:[],
                message:null
        }
    }

    componentDidMount() {
        this.refreshPessoas();
    }

    refreshPessoas(){
        PessoaDataService.retriveAllPessoas()
            .then(
                response => {
                    console.log(response);
                    this.setState({pessoas:response.data})

                }
            )
    }

    success = (record) => {
        if(record.isVacinada){
            record.isVacinada = false;
        }else record.isVacinada = true;
        PessoaDataService.updatePessoa(record, record.codigo);
        message.success('Status alterado com sucesso!');   
    }

    render(){
    return (
            <div className="container">
                <h2>PESSOAS CADASTRADAS</h2>
                <div>
                    <Table dataSource={this.state.pessoas}>
                        <Column title="NOME" dataIndex="nome" key="nome"/>
                        <Column title="CPF" dataIndex="cpf" key="cpf"/>
                        <Column title="TELEFONE" dataIndex="telefone" key="telefone"/>
                        <Column title="EMAIL" dataIndex="email" key="email"/>
                        <Column title="VACINADA" dataIndex="isVacinada" key="isVacinada" render={(text, record) => (<p>{String(record.isVacinada)}</p>)} />
                        <Column title="ATUALIZAR" key="atualizar" render = {(text, record) => (<Button onClick={() => this.success(record)}type="primary">Alterar Status</Button>)}
                        />
                    </Table>
                </div>
             </div>
        )
    }
}
  
  }
  
  ```
  #### Services/ PessoaDataService.js
  
  ```
  {
   import axios from 'axios';

const API_URL = 'http://localhost:8080/';

class PessoaDataService{
    retriveAllPessoas(){
        return axios.get(`${API_URL}pessoas`)
    }
   updatePessoa(pessoa, codigo) {
       return axios.put(`${API_URL}pessoas/${codigo}`,pessoa);
   }
}
export default new PessoaDataService();
                  
   }
  ```
                  
  #### App.css
  
  ```
   {
         .App {
  text-align: center;
}

.App-logo {
  height: 40vmin;
  pointer-events: none;
}

@media (prefers-reduced-motion: no-preference) {
  .App-logo {
    animation: App-logo-spin infinite 20s linear;
  }
}

.App-header {
  background-color: #282c34;
  min-height: 100vh;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  font-size: calc(10px + 2vmin);
  color: white;
}

.App-link {
  color: #61dafb;
}

@keyframes App-logo-spin {
  from {
    transform: rotate(0deg);
  }
  to {
    transform: rotate(360deg);
  }
}
         
    }
  ```
                  
                  
                  
  #### App.js
 
  ```
   {
                  import { Layout, Menu, Breadcrumb } from 'antd';
import "antd/dist/antd.css";
import ListaPessoas from './componentes/ListaPessoas';
const { Header, Content, Footer } = Layout;

export default function App() {
  return (
    <div>
      <Layout className="layout">
        <header>
          <div className="logo">
          <Menu theme="dark" mode="horizontal" defaultSelectedKeys={['1']}>
            <Menu.Item key="1">Home</Menu.Item>
          </Menu>
          </div>
        </header>
      <Content style={{ padding: '0 50px' }}>
        <div className="site-layout-content">
          
          
          <ListaPessoas></ListaPessoas>
        </div>
      </Content>
      <Footer style={{ textAlign: 'center' }}>eVaccine - Roberta Design Pattern</Footer>
   </Layout>
  </div >
  );
}


    }
  ```
  
                  
#### index.css
                  
 ```
 {
                  body {
  margin: 0;
  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', 'Roboto', 'Oxygen',
    'Ubuntu', 'Cantarell', 'Fira Sans', 'Droid Sans', 'Helvetica Neue',
    sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}

code {
  font-family: source-code-pro, Menlo, Monaco, Consolas, 'Courier New',
    monospace;
}

  }                
 ``
                  
                  `
  >>
---
 [![ mp4] ](https://www.youtube.com/watch?v=<https://www.youtube.com/watch?v=t-x5JZ-0d5k)
