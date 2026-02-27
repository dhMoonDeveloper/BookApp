export async function GET() {
  return Response.json({ message: 'GET 성공' })
}

export async function POST(request: Request) {
  const body = await request.json()
  return Response.json({ message: 'POST 성공', data: body })
}