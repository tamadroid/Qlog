- [日本語](README_jp.md) 
# Qlog
Library to simplify Android Logs.
It allows you to easily output various outputs with little or no configuration.

## Setup
`Implementation 'jp.tama:qlog:0.2.2'`

## Usage
### Advance Preparation
Do the following at the first Activity to be launched or at the "onCreate" of the Application.  
`Qlog.set(BuildConfig.DEBUG)`

#### If you want fine control
##### output the log (can be resumed at any time)
`Qlog.set(true)`
##### Stop logging (can be stopped at any time)
`Qlog.set(false)`

### Actual Use
`Qlog.d("test")`  
> Qlog.d "d" can be used for e, w, i, d, v

### Execution Results
`D/(MainActivity.kt:24)[TH:UI][onCreate]: test`
- MainActivity.kt:24  
Run in line 24 of the MainActivity.kt file
- [TH:UI]  
The execution thread is the UI (UI: UI thread, Work: Worker thread)
- [onCreate]  
Execution method name (hidden if you can't get it by coroutines, etc.)
- test  
The character string you want to display. Variables, etc. are also possible (type Any, so you can register them without worrying about the type.
 
## License.
This software is released under the MIT License, see LICENSE.
