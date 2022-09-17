#!/usr/bin/env node
import 'source-map-support/register';
import * as cdk from 'aws-cdk-lib';
import { InfraStack } from '../lib/infra-stack';

const app = new cdk.App();
new InfraStack(app, 'soen343', {
 env :{
  account:"628013712810",
  region:"us-east-1",

 }
});