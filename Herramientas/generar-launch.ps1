# ============================================================
#  C:\Users\mañana\Desktop\java\Herramientas\generar-launch.ps1
# ------------------------------------------------------------
#  Crea .vscode\launch.json con una configuración por cada
#  ejercicio .java de src\main\java, para poder lanzarlos con
#  F5 o desde el menú Run de Visual Studio Code.
#
#  USO:  ejecútalo cada vez que añadas un ejercicio nuevo.
#        (No hace falta tocar nada a mano.)
# ============================================================

$proyecto = Join-Path (Split-Path -Parent $PSScriptRoot) "Java\Proyecto"
$carpeta = Join-Path $proyecto "src\main\java"

if (-not (Test-Path -LiteralPath $carpeta)) {
    Write-Host "  No encuentro $carpeta" -ForegroundColor Red
    exit 1
}

# ---- cada .java aporta su paquete y su clase ----
$archivos = Get-ChildItem -LiteralPath $carpeta -Recurse -File -Filter *.java |
    Sort-Object FullName

$configuraciones = @()
$num = 0

foreach ($a in $archivos) {

    $num++

    # el paquete es la linea "package X;" del propio archivo
    $texto = Get-Content -LiteralPath $a.FullName -Raw -Encoding UTF8
    $m = [regex]::Match($texto, '(?m)^\s*package\s+([\w\.]+)\s*;')
    $paquete = if ($m.Success) { $m.Groups[1].Value } else { "" }

    $clase = [IO.Path]::GetFileNameWithoutExtension($a.Name)
    $claseCompleta = if ($paquete -ne "") { "$paquete.$clase" } else { $clase }

    # nombre legible: "Dia 1 - Ejercicio 1 - Ej1"
    $carpetaEjercicio = $a.Directory.Name -replace '_', ' '
    $nombre = "$num) $carpetaEjercicio - $clase"

    $configuraciones += @"
		{
			"type": "java",
			"name": "$nombre",
			"request": "launch",
			"mainClass": "$claseCompleta",
			"console": "integratedTerminal",
			"preLaunchTask": "Compilar proyecto (javac)"
		}
"@
}

$json = @"
{
    "version": "0.2.0",
    "configurations": [
$($configuraciones -join ',')
    ]
}
"@

$salida = Join-Path $proyecto ".vscode\launch.json"
[IO.File]::WriteAllText($salida, $json, (New-Object System.Text.UTF8Encoding $false))

Write-Host ""
Write-Host "  launch.json escrito con $($configuraciones.Count) ejercicios" -ForegroundColor Green
Write-Host "  en: $salida" -ForegroundColor Cyan
Write-Host ""