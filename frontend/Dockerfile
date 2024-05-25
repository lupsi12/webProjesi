# Stage 1: Node.js tabanlı bir imaj ile uygulamayı build etmek
FROM node:16 as build

# Çalışma dizinini belirle
WORKDIR /app

# package.json ve package-lock.json dosyalarını kopyala
COPY package*.json ./

# Bağımlılıkları yükle
RUN npm install

# Uygulama dosyalarını kopyala
COPY . .

# Uygulamayı build et
RUN npm run build

# Stage 2: Nginx kullanarak statik dosyaları servis etmek
FROM nginx:alpine

# Nginx için yapılandırma dosyasını kopyala
COPY --from=build /app/build /usr/share/nginx/html

# Gerekli ise Nginx yapılandırma dosyasını kopyala
COPY nginx.conf /etc/nginx/conf.d/default.conf

# Portu aç
EXPOSE 80

# Nginx'i başlat
CMD ["nginx", "-g", "daemon off;"]
