var config = {
   entry: './main.js',

   output: {
      path:'D:\\ReactFolder\\reactApp',
      filename: 'index.js',
   },

   devServer: {
      inline: true,
      port: 8089
   },

   module: {
      loaders: [
         {
            test: /\.jsx?$/,
            exclude: /node_modules/,
            loader: 'babel-loader',

            query: {
               presets: ['es2015', 'react']
            }
         }
      ]
   }
}

module.exports = config;
