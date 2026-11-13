const http = require('node:http');
const plans = [{days:1,price:25},{days:3,price:70},{days:7,price:160},{days:30,price:350}];
const server = http.createServer((req,res)=>{
 res.setHeader('Content-Type','application/json; charset=utf-8');
 res.setHeader('Access-Control-Allow-Origin','*');
 if(req.method==='GET' && req.url==='/api/plans') return res.end(JSON.stringify({plans,demo:true}));
 if(req.method==='GET' && req.url==='/api/status') return res.end(JSON.stringify({status:'demo',paymentsEnabled:false,otpEnabled:false}));
 res.statusCode=404; res.end(JSON.stringify({error:'Not found'}));
});
server.listen(process.env.PORT || 3000,()=>console.log('TRITON demo API ready'));
