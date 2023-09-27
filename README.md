# invokeLambda
The Project execute the invocation lambda directly app Java

1 - Execute the localstack
    docker run --rm -d -p 4566:4566 -p 4510-4559:4510-4559 -e localstack/localstack

2 - Create the lambda function (there is a folder called lambda in the project already with function code compacted)
    aws --endpoint-url=http://localhost:4566 lambda create-function \
    --region us-west-2 \
    --function-name localstack-lambda-url-example \
    --zip-file fileb://function.zip \
    --role arn:aws:iam::000000000000:role/localstack-role \
    --handler lambda-test.handler \
    --timeout 5 \
    --runtime nodejs10.x

3 - Execute a request to endepoint: http://127.0.0.1:9090/invoke/test, method: GET

