@echo off
echo ========================================
echo  Ouverture de toutes les pages pour screenshots
echo ========================================
echo.
echo Attendez 3 secondes entre chaque page...
echo.

start demo-static\index.html
timeout /t 3 /nobreak > nul

start demo-static\products.html
timeout /t 3 /nobreak > nul

start demo-static\categories.html
timeout /t 3 /nobreak > nul

start demo-static\product-form.html

echo.
echo ========================================
echo  Toutes les pages sont ouvertes !
echo ========================================
echo.
echo Maintenant :
echo 1. Appuyez sur Windows + Shift + S
echo 2. Selectionnez chaque page
echo 3. Enregistrez dans le dossier screenshots/
echo.
echo Fichiers a creer :
echo - screenshots/home.png
echo - screenshots/products.png
echo - screenshots/categories.png
echo - screenshots/product-form.png
echo.
pause

