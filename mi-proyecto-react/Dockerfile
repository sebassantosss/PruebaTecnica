# Etapa 1: Compilación
FROM node:20-alpine AS builder

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar los archivos de configuración de dependencias
COPY package.json package-lock.json* ./

# Instalar las dependencias
RUN npm install

# Copiar el resto del código fuente del frontend
COPY . .

# Construir la aplicación para producción (Vite crea la carpeta 'dist')
RUN npm run build

# Etapa 2: Servidor Nginx para la imagen final liviana
FROM nginx:alpine

# Limpiar los archivos por defecto de Nginx
RUN rm -rf /usr/share/nginx/html/*

# Copiar la configuración personalizada de Nginx
COPY nginx.conf /etc/nginx/conf.d/default.conf

# Copiar los archivos compilados de Vite (carpeta dist) al directorio de Nginx
COPY --from=builder /app/dist /usr/share/nginx/html

# Exponer el puerto 80 para acceder al frontend
EXPOSE 80

# Comando para iniciar Nginx
CMD ["nginx", "-g", "daemon off;"]
