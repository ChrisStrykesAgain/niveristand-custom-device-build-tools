package ni.vsbuild.v2.steps

import ni.vsbuild.v2.BuildConfiguration

abstract class AbstractStep implements Step {

   def script
   def name
   
   AbstractStep(script, jsonStep) {
      this.script = script
      this.name = jsonStep.getString('name')
   }
   
   void execute(BuildConfiguration configuration) {
      script.echo "Step $name beginning..."
      executeStep(configuration)
      script.echo "Step $name complete."
   }
   
   abstract void executeStep(BuildConfiguration configuration)
}
