# 🚑 Sistema de Gestión de Emergencias Médicas Concurrente

Simulación de un sistema de gestión y despacho de emergencias médicas utilizando concurrencia en Java.  
Permite manejar múltiples emergencias en tiempo real, asignando recursos de manera eficiente y priorizando la atención según la urgencia.

---

## 📋 Descripción

Este proyecto implementa un sistema concurrente para la atención de emergencias médicas.  
Utiliza una arquitectura modular, patrones de diseño y estructuras concurrentes para garantizar la eficiencia, seguridad y escalabilidad en la gestión de recursos críticos como ambulancias.

---

## 🚀 Características principales

- **Arquitectura en capas:** Separación clara entre modelo, lógica de negocio, concurrencia e interfaz.
- **Concurrencia real:** Múltiples hilos para atención simultánea de emergencias.
- **Patrón Producer-Consumer:** Emergencias gestionadas mediante una cola de prioridad concurrente.
- **Gestión centralizada de recursos:** Uso de Singleton para el manejo seguro de ambulancias y personal.
- **Prevención de deadlocks:** Monitoreo activo y manejo seguro de recursos compartidos.
- **Interfaz de consola:** Visualización en tiempo real del estado del sistema.
- **Tecnologías:** Java 17, Maven.

---

## 📂 Estructura del proyecto

/src
- ** └── main
- └── java
- └── com
- └── iudigital
- ├── model # Clases de dominio (Emergencia, Recurso)
- ├── service # Lógica y gestión de negocio
- ├── thread # Hilos para concurrencia
- ├── view # Interfaz de usuario en consola
- └── Main.java # Clase principal para arrancar el sistema



---

## ⚙️ Instalación y ejecución

1. **Clona el repositorio:**
   ```bash
   git clone https://github.com/Deiner-Calanche/gestion-emergencias-medicas
   cd gestion-emergencias-medicas
   



mvn clean install
Ejecuta la aplicación:


mvn exec:java -Dexec.mainClass="com.iudigital.Main"
🖥️ Uso básico
El sistema mostrará en consola las emergencias recibidas, su prioridad y la asignación de recursos.

Puedes simular la llegada de nuevas emergencias y observar cómo se despachan en tiempo real.

📦 Dependencias principales
Java 17

Maven

📬 Contacto
Deiner Calanche Villa
📧 deiner.calanche@est.iudigital.edu.co
📱 3147934341
