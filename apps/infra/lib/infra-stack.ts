import * as cdk from 'aws-cdk-lib';
import * as dynamo from 'aws-cdk-lib/aws-dynamodb';
import { Construct } from 'constructs';
// import * as sqs from 'aws-cdk-lib/aws-sqs';

export class InfraStack extends cdk.Stack {
  constructor(scope: Construct, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    const projectID = "soen-343";
    const table = new dynamo.Table(this,`${projectID}-table`,{
      tableName :`${projectID}-table`,
      partitionKey:{
        name: 'id',
        type: dynamo.AttributeType.STRING
      },
        sortKey:{
          name: "sk",
          type: dynamo.AttributeType.STRING
        },
        readCapacity:1,
        writeCapacity:1,
    });
      table.addGlobalSecondaryIndex({
        indexName: "email-index",
        partitionKey:{
          name: 'email',
          type: dynamo.AttributeType.STRING
        },
        sortKey:{
          name: "sk",
          type: dynamo.AttributeType.STRING
        },
        readCapacity:1,
        writeCapacity:1,
      });
  }
}
